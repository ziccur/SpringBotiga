package iticbcn.yeray.mvc.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import iticbcn.yeray.mvc.DTO.LlibreDTO;
import iticbcn.yeray.mvc.Model.Llibre;
 
@Mapper(componentModel = "spring")
public interface LlibreMapper {
 
    @Mapping(target="titol", source="llibre.titol")
    @Mapping(target="autor", source="llibre.autor")
    @Mapping(target="editorial", source="llibre.editorial")
    @Mapping(target = "datapublicacio", source = "llibre.datapublicacio")
    @Mapping(target = "tematica", source = "llibre.tematica")
    LlibreDTO LlibreToLlibreDTO(Llibre llibre);
 
    @Mapping(target="titol", source="llibreDTO.titol")
    @Mapping(target="autor", source="llibreDTO.autor")
    @Mapping(target="editorial", source="llibreDTO.editorial")
    @Mapping(target = "datapublicacio", source = "llibreDTO.datapublicacio")
    @Mapping(target = "tematica", source = "llibreDTO.tematica")
    Llibre LlibreDTOToLlibre(LlibreDTO llibreDTO);
 
}