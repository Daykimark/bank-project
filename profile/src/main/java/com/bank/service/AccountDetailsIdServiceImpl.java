package com.bank.service;

import com.bank.dao.AccountDetailsIdDao;
import com.bank.dto.AccountDetailsIdDto;
import com.bank.model.AccountDetailsIdEntity;
import lombok.RequiredArgsConstructor;
import com.bank.mapper.AccountDetailsIdMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
     * @param id
     * @return
     */
    @Override
    public List<AccountDetailsIdDto> findAllById(Iterable<Long> id) {
        return accountDetailsIdMapper.toDtoList(new ArrayList<>(accountDetailsIdDao.findAllById(id)));
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
        AccountDetailsIdEntity entity = accountDetailsIdMapper.toEntity(accountDetailsIdDto);
        return accountDetailsIdMapper.toDto(accountDetailsIdDao.save(entity));
    }
}
