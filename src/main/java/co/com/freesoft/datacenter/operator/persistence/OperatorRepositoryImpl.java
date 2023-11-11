package co.com.freesoft.datacenter.operator.persistence;

import co.com.freesoft.datacenter.operator.persistence.entities.OperatorEntity;
import co.com.freesoft.datacenter.operator.persistence.mappers.OperatorMapper;
import co.com.freesoft.datacenter.operator.persistence.repositories.OperatorCrudRepository;
import co.com.freesoft.datacenter.operator.persistence.repositories.OperatorPaginationRepository;
import co.com.freesoft.datacenter.operator.services.OperatorServiceRepository;
import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.UpdateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.OperatorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class OperatorRepositoryImpl implements OperatorServiceRepository {

    private final OperatorCrudRepository operatorCrudRepository;
    private final OperatorPaginationRepository operatorPaginationRepository;
    private final OperatorMapper operatorMapper;

    @Override
    public OperatorDto createOperator(CreateOperatorDto createOperatorDto) {
        OperatorEntity newOperator = this.operatorMapper.toOperatorEntity(createOperatorDto);
        OperatorEntity responseQuery = this.operatorCrudRepository.save(newOperator);
        return operatorMapper.toOperatorDto(responseQuery);
    }

    @Override
    public Page<OperatorDto> findAllOperators(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.operatorPaginationRepository.findAll(pageRequest).map(this.operatorMapper::toOperatorDto);
    }

    @Override
    public Optional<OperatorDto> findOneOperator(Long id) {
        return this.operatorCrudRepository.findById(id).map(this.operatorMapper::toOperatorDto);
    }

    @Override
    public Optional<OperatorDto> updateOperator(UpdateOperatorDto updateOperatorDto, Long id) {
        OperatorEntity operatorEntityById = this.operatorCrudRepository.findById(id).orElse(null);
        if(operatorEntityById == null) return Optional.empty();;
        OperatorEntity operatorEntityUpdate = this.operatorMapper.merge(updateOperatorDto, operatorEntityById);
        OperatorEntity responseQuery = this.operatorCrudRepository.save(operatorEntityUpdate);
        return Optional.of(operatorMapper.toOperatorDto(responseQuery));
    }

    @Override
    public void removeOperator(Long id) {
        this.operatorCrudRepository.deleteById(id);
    }
}

  