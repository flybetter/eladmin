package me.zhengjie.service;

public interface ImpalaService<T> {
    String queryCountList(String startDate, String endDate, String deviceId);
}
