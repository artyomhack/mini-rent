package org.artyomhack.model;

import lombok.Data;

/**
 * Модель, которая представляет сведения о файле.
 */
@Data
public class FileInfo {

    private String filename;

    private byte[] data;
}
