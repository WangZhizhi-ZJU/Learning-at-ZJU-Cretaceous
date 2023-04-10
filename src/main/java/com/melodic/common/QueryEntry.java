package com.melodic.common;

public class QueryEntry<T> {
    T condition;
    Integer currentIndex;
    Integer pageSize;

    public QueryEntry(T condition, Integer currentIndex, Integer pageSize) {
        this.condition = condition;
        this.currentIndex = currentIndex;
        this.pageSize = pageSize;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryEntry{" +
                "condition=" + condition +
                ", currentIndex=" + currentIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
