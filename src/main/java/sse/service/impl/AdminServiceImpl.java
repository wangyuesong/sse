package sse.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.dao.impl.WillDaoImpl;

@Service
public class AdminServiceImpl {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private WillDaoImpl willDaoImpl;

}
