/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.UserInfo;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface UserInfoDao {
    public void add(UserInfo userInfo);

    public void delete(UserInfo userInfo);

    public void update(UserInfo userInfo);

    public UserInfo getById(int id);

    public List<UserInfo> getAll();
}
