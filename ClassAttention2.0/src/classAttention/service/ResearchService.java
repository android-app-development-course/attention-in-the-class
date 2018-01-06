package classAttention.service;


import classAttention.dao.ResearchDao;
import classAttention.domain.Research;

public class ResearchService {
    ResearchDao researchDao = new ResearchDao();

    public void addResearchInfo(Research research){

        Research  researchInDataBase = researchDao.getByUidAndClassId(research.getUid(),research.getClassId());
        if (researchInDataBase != null){
            researchDao.deleteByResearchId(researchInDataBase.getClassId());
        }
        researchDao.add(research);
    }
}
