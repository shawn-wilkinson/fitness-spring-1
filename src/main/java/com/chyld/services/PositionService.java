package com.chyld.services;

import com.chyld.entities.Position;
import com.chyld.repositories.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    private IPositionRepository positionRepository;

    @Autowired
    public void setPositionRepository(IPositionRepository positionRepository) { this.positionRepository = positionRepository;}
    public Position savePosition(Position position) { return positionRepository.save(position); }
}
