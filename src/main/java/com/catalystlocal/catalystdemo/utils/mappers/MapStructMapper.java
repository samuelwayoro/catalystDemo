package com.catalystlocal.catalystdemo.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.catalystlocal.catalystdemo.models.Personne;
import com.catalystlocal.catalystdemo.utils.mappers.dtos.PersonneGetDto;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
	
	MapStructMapper myMapper = Mappers.getMapper(MapStructMapper.class);
	
	PersonneGetDto toDto(Personne personne);
}
