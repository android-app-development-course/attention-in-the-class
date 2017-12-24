package classAttention.dao;

import classAttention.domain.Research;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import yong.tool.jdbc.TxQueryRunner;
import java.sql.SQLException;

public class ResearchDao {

    private QueryRunner qr = new TxQueryRunner();

    public Research getByUidAndClassId(String uid,int classId){
        try{
            String sql="select * from research_info where uid=? and classId=?";
            return qr.query(sql, new BeanHandler<>(Research.class), uid,classId);
        }catch (SQLException e){

            throw new RuntimeException(e);
        }
    }

    public void add(Research research){
        try{
            String sql = "insert into research_info(uid,classId,informationJson) value(?,?,?)";
            Object[] params = {research.getUid(),research.getClassId(),research.getInformationJson()};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deleteByResearchId(int researchId){
        try{
            String sql="delete from research_info where researchId=?";
            Object[] params ={researchId};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
