/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaCaja;
import DTOSalida.DTOSalidaCaja;
import POJOs.Caja;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaCaja, DTOSalidaCaja y Caja (POJO).
 * Convierte correctamente los ObjectId y los campos necesarios.
 *
 * @author SDavidLedesma
 */
public class CajaMapper {

    /**
     * Convierte de DTOEntradaCaja a Caja (POJO).
     *
     * @param dto
     * @return
     */
    public static Caja toEntityFromEntrada(DTOEntradaCaja dto) {
        Caja caja = new Caja();
        caja.setFechaHoraApertura(dto.getFechaHoraApertura());
        caja.setMontoInicial(dto.getMontoInicial());

        caja.setUsuarioApertura(null);//se establece desde dao
        return caja;
    }

    /**
     * Convierte de Caja (POJO) a DTOSalidaCaja.
     *
     * @param caja
     * @return
     */
    public static DTOSalidaCaja toDTOSalida(Caja caja) {
        DTOSalidaCaja dto = new DTOSalidaCaja();
        dto.setIdCaja(caja.getId() != null ? caja.getId().toHexString() : null);
        dto.setFechaHoraApertura(caja.getFechaHoraApertura());
        dto.setMontoInicial(caja.getMontoInicial());
        dto.setFechaHoraCierre(caja.getFechaHoraCierre());
        dto.setMontoFinal(caja.getMontoFinal());
        dto.setTotalVentas(caja.getTotalVentas());
        dto.setObservaciones(caja.getObservaciones());

        return dto;
    }

    /**
     * Convierte de DTOSalidaCaja a Caja (POJO).
     *
     * @param dto
     * @return
     */
    public static Caja toEntityFromSalida(DTOSalidaCaja dto) {
        Caja caja = new Caja();

        // ID de la caja
        if (dto.getIdCaja() != null && !dto.getIdCaja().isEmpty()) {
            caja.setId(new ObjectId(dto.getIdCaja()));
        }

        caja.setFechaHoraApertura(dto.getFechaHoraApertura());
        caja.setMontoInicial(dto.getMontoInicial());
        caja.setFechaHoraCierre(dto.getFechaHoraCierre());
        caja.setMontoFinal(dto.getMontoFinal());
        caja.setTotalVentas(dto.getTotalVentas());
        caja.setObservaciones(dto.getObservaciones());

        caja.setUsuarioApertura(dto.getUsuarioApertura());

        caja.setUsuarioCierre(dto.getUsuarioCierre());

        return caja;
    }
}
