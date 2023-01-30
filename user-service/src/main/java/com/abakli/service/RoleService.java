package com.abakli.service;

import com.abakli.dto.RoleDTO;
import com.abakli.exception.UserServiceException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id) throws UserServiceException;
}
