package co.com.freesoft.datacenter.operator.services;

import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.UpdateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.OperatorDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface OperatorServiceRepository {

    public OperatorDto createOperator(CreateOperatorDto createOperatorDto);

    public Page<OperatorDto> findAllOperators(int page, int limit, String sortBy);

    public Optional<OperatorDto> findOneOperator(Long id);

    public Optional<OperatorDto> updateOperator(UpdateOperatorDto updateOperatorDto, Long id);

    public void removeOperator(Long id);
}

  