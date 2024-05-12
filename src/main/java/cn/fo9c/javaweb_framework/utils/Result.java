package cn.fo9c.javaweb_framework.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
// Serializable接口用于序列化对象，使其能够在网络上传输
// <T>表示泛型方法,用于表示Result能处理任意类型的数据
public class Result<T> implements Serializable {
    // 自定义Result类，用于封装返回结果
    private Integer code;   // 程序完成状态编码  默认0成功，1和其它数字为失败
    private String msg;     // 错误或提示信息
    private Object data;    // 封装的数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = "success";
        result.data = new ArrayList<>();
        return result;
    }

    public static <T> Result<T> success(String msg, Object Data) {
        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        result.data = Data;
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = "error";
        result.data = new ArrayList<>();
        return result;
    }

public static <T> Result<T> error(String msg, Object Data) {
        Result<T> result = new Result<>();
        result.code = 1;
        result.msg = msg;
        result.data = Data;
        return result;
    }
}
