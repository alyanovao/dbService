package ru.aao.dbservice.dbservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aao.dbservice.dbservice.repository.CardRepository;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public String getResource() {
        return cardRepository.getResource();
    }
}
