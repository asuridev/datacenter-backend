package co.com.freesoft.datacenter.operator.services;

import co.com.freesoft.datacenter.common.exceptions.NotFoundException;
import co.com.freesoft.datacenter.operator.services.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OperatorService {

    private final OperatorServiceRepository operatorServiceRepository;
    private final ConverterOperatorDto converterOperatorDto;

    public ResponseOperatorDto create(CreateOperatorDto createOperatorDto){
        OperatorDto operator = operatorServiceRepository.createOperator(createOperatorDto);
        return this.converterOperatorDto.toResponseOperatorDto(operator);
    }

    public Page<ResponseOperatorDto> findAll(int page, int limit, String sortBy){
        Page<OperatorDto> operators = operatorServiceRepository.findAllOperators(page, limit ,sortBy);
        return  operators.map(converterOperatorDto::toResponseOperatorDto);
    }

    public ResponseOperatorDto findOne(Long id){
        OperatorDto operator = operatorServiceRepository.findOneOperator(id).orElseThrow(NotFoundException::new);
        return this.converterOperatorDto.toResponseOperatorDto(operator);
    }

    public ResponseOperatorDto update(UpdateOperatorDto updateOperatorDto, Long id){
        OperatorDto operator = operatorServiceRepository.updateOperator(updateOperatorDto, id).orElseThrow(NotFoundException::new);
        return this.converterOperatorDto.toResponseOperatorDto(operator);
    }

    public void remove(Long id){
        this.findOne(id);
        operatorServiceRepository.removeOperator(id);
    }
}

  