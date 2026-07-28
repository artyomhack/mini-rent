package org.artyomhack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Модель, которая представляет сведения о файле.
 */
@Data
@AllArgsConstructor
public class FileInfo {

    private byte[] data;

    private String filename;
}
