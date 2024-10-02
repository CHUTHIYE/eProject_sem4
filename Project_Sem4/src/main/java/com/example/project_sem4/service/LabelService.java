package com.example.project_sem4.service;

import com.example.project_sem4.dto.LabelDTO;
import com.example.project_sem4.entity.Label;
import com.example.project_sem4.repository.LabelRepository; // Ensure this repository is created
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabelService implements ILabelService {

    @Autowired
    private LabelRepository labelRepository;

    private Label convertToEntity(LabelDTO labelDTO) {
        Label label = new Label();
        label.setLabelId(labelDTO.getLabelId());
        label.setLabelName(labelDTO.getLabelName());
        return label;
    }

    private LabelDTO convertToDTO(Label label) {
        LabelDTO labelDTO = new LabelDTO();
        labelDTO.setLabelId(label.getLabelId());
        labelDTO.setLabelName(label.getLabelName());
        return labelDTO;
    }

    @Override
    public List<LabelDTO> getAllLabels() {
        return labelRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LabelDTO getLabelById(int labelId) {
        Optional<Label> label = labelRepository.findById(labelId);
        return label.map(this::convertToDTO).orElse(null);
    }

    @Override
    public void saveLabel(LabelDTO labelDTO) {
        Label label = convertToEntity(labelDTO);
        labelRepository.save(label);
    }

    @Override
    public void updateLabel(int labelId, LabelDTO labelDTO) {
        Optional<Label> existingLabelOptional = labelRepository.findById(labelId);
        if (existingLabelOptional.isPresent()) {
            Label existingLabel = existingLabelOptional.get();
            existingLabel.setLabelName(labelDTO.getLabelName());
            labelRepository.save(existingLabel);
        } else {
            throw new RuntimeException("Label not found with id: " + labelId);
        }
    }

    @Override
    public void deleteLabel(int labelId) {
        if (labelRepository.existsById(labelId)) {
            labelRepository.deleteById(labelId);
        } else {
            throw new RuntimeException("Label not found with id: " + labelId);
        }
    }
}
