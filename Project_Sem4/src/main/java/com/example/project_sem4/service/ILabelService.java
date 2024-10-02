package com.example.project_sem4.service;

import com.example.project_sem4.dto.LabelDTO;
import java.util.List;

public interface ILabelService {
    List<LabelDTO> getAllLabels();
    LabelDTO getLabelById(int labelId);
    void saveLabel(LabelDTO labelDTO);
    void updateLabel(int labelId, LabelDTO labelDTO);
    void deleteLabel(int labelId);
}
