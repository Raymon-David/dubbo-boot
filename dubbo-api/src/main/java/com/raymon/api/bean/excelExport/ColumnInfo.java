package com.raymon.api.bean.excelExport;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Getter
@Setter
public class ColumnInfo {
    private String prompt;
    private Integer width;
    private String name;
    private String align;
    private List<ColumnInfo> column;

    public int getCellCount() {
        if (CollectionUtils.isEmpty(column)) {
            return 1;
        }
        int cellCount = 0;
        for (ColumnInfo columnInfo : column) {
            int count = columnInfo.getCellCount();
            cellCount += count;
        }
        return cellCount;
    }

    public int getDepth(){
        if (CollectionUtils.isEmpty(column)) {
            return 1;
        }
        int depth = 1;
        for (ColumnInfo columnInfo : column) {
            int columnDepth = columnInfo.getDepth() + 1;
            if(depth < columnDepth){
                depth = columnDepth;
            }
        }
        return depth;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public List<ColumnInfo> getColumn() {
        return column;
    }

    public void setColumn(List<ColumnInfo> column) {
        this.column = column;
    }
}
