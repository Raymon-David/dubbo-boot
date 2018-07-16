package com.raymon.pojo;

import java.io.Serializable;

public class BaseModel implements Serializable {
    private static final long serialVersionUID = -5810847822429055940L;

    private String bootstrapId;

    public String getBootstrapId() {
        return bootstrapId;
    }

    public void setBootstrapId(String bootstrapId) {
        this.bootstrapId = bootstrapId;
    }
}
