package com.abakli.service.impl;

import com.abakli.dto.RoleDTO;
import com.abakli.entity.Role;
import com.abakli.exception.UserServiceException;
import com.abakli.repository.RoleRepository;
import com.abakli.service.RoleService;
import com.abakli.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepository roleRepository;
    private final MapperUtil mapperUtil;

    public RoleServiceImpl(RoleRepository roleRepository, MapperUtil mapperUtil) {
        this.roleRepository = roleRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj,new RoleDTO())).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long id) throws UserServiceException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new UserServiceException("Role does not exists"));
        return mapperUtil.convert(role,new RoleDTO());
    }
}
