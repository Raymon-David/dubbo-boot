package com.raymon.api.utils.poi.callback;

import java.util.Map;

public interface Callback {
    void callback(Map<String,String> result, int currentRowNumber, int availabledRows);
}
