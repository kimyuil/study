package util;

import java.util.List;

import service.WorshipList;

public interface MakeFile {

    public void download(String fileName, List<WorshipList> content);
}
