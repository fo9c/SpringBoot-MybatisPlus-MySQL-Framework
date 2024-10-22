package cn.fo9c.javaweb_framework.utils;

public class SnowFlakeID {
    /**
     * * 构造函数
     * @param workerId     工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    public SnowFlakeID(long workerId, long datacenterId) {

        // 支持的最大机器id,结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
        final long maxWorkerId = ~(-1L << workerIdBits);

        // 支持的最大数据标识id,结果是31
        final long maxDatacenterId = ~(-1L << datacenterIdBits);

        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public SnowFlakeID() {}

    /**
     * * 返回一个String类型的雪花ID (该方法是线程安全的)
     * @return SnowFlakeID
     */
    public synchronized String generator() {
        long timestamp = timeGen();

        // 开始时间截 (2018-12-03)
        final long twepoch = 1543766400000L;

        // 序列在id中占的位数
        final long sequenceBits = 12L;

        // 数据标识id向左移17位(12+5)
        final long datacenterIdShift = sequenceBits + workerIdBits;

        // 时间截向左移22位(5+5+12)
        final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

//        // 机器ID向左移12位
//        final long workerIdShift = sequenceBits;

        // 生成序列的掩码,这里为4095 (0b111111111111=0xfff=4095)
        final long sequenceMask = ~(-1L << sequenceBits);

        // 如果当前时间小于上一次生成ID的时间戳,说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // 如果是同一时间生成的,则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 时间戳改变,毫秒内序列重置
        else {
            sequence = 0L;
        }

        // 上次生成的时间截
        lastTimestamp = timestamp;

        // 移位并通过或运算拼到一起组成64位的ID
        return String.valueOf(((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << sequenceBits)
                | sequence);
    }



    // 机器id所占的位数
    private final long workerIdBits = 5L;

    // 数据标识id所占的位数
    private final long datacenterIdBits = 5L;

    // 工作机器ID(0~31)
    private long workerId;

    // 数据中心ID(0~31)
    private long datacenterId;

    // 毫秒内序列(0~4095)
    private long sequence = 0L;

    // 上次生成ID的时间截
    private long lastTimestamp = -1L;


    /**
     * * 阻塞到下一个毫秒,直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }
}
