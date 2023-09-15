package com.nisum.demo.serviceImpl;

import com.nisum.demo.DAO.UsuarioPhoneDAO;
import com.nisum.demo.entity.DTO.PhoneDTO;
import com.nisum.demo.entity.Usuario;
import com.nisum.demo.entity.UsuarioPhone;
import com.nisum.demo.service.UsuarioPhoneService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioPhoneServiceImpl implements UsuarioPhoneService {

    private UsuarioPhoneDAO oUsuarioPhoneDAO;

    public UsuarioPhoneServiceImpl(UsuarioPhoneDAO oUsuarioPhoneDAO) {
        this.oUsuarioPhoneDAO = oUsuarioPhoneDAO;
    }

    public List<UsuarioPhone> savePhone(List<PhoneDTO> listPhoneDTO, Usuario oUsuario)  {
        List<UsuarioPhone> listUsuarioPhone = new ArrayList<>();
        listPhoneDTO.stream().forEach(p -> {
            if(p.getCityCode() == null || p.getCountryCode() == null || p.getNumber() == null){
                    throw new IllegalArgumentException("Los campos no son nulables");
            }
            UsuarioPhone oUsuarioPhone = new UsuarioPhone(p);
            oUsuarioPhone.setUsuario(oUsuario);
            listUsuarioPhone.add(oUsuarioPhone);
        });


        return oUsuarioPhoneDAO.saveAll(listUsuarioPhone);
    }
}
