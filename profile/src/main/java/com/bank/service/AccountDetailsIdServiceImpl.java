package com.bank.service;

import com.bank.dao.AccountDetailsIdDao;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.mapper.AccountDetailsIdMapper;
import com.bank.model.AccountDetailsIdEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService{
    private final AccountDetailsIdDao accountDetailsIdDao;
    private final AccountDetailsIdMapper accountDetailsIdMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public AccountDetailsIdDto findById(Long id) {
        return accountDetailsIdMapper.toDto(accountDetailsIdDao.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<AccountDetailsIdDto> findAllById(List<Long> ids) {
        List<AccountDetailsIdEntity> dtoList = accountDetailsIdDao.findAllById(ids);
        if (dtoList.size() < ids.size()) {
            throw new EntityNotFoundException("one of ids doesn't exist " + ids);
        }
        return accountDetailsIdMapper.toDtoList(dtoList);
    }

    /**
     * @return
     */
    @Override
    public List<AccountDetailsIdDto> findAll() {
        return accountDetailsIdMapper.toDtoList(accountDetailsIdDao.findAll());
    }

    /**
     * @param accountDetailsIdDto
     * @return
     */
    @Override
    public AccountDetailsIdDto save(AccountDetailsIdDto accountDetailsIdDto) {
        accountDetailsIdDao.save(accountDetailsIdMapper.toEntity(accountDetailsIdDto));
        return accountDetailsIdDto;
    }
}
