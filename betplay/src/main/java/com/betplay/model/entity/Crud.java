package com.betplay.model.entity;

import java.util.List;

public interface Crud {
    public void add();
    public <T> List<T> listar();
    }

