package com.csis3275.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model.FileUpload;


@Component
public class FileUploadInDb {
	static JdbcTemplate jdbcTemplateObj;
	private final static  String sqlInsertQuery="INSERT INTO files_upload (file_name, file_description, file_data) VALUES (?, ?, ?)";
	private final String SQL_DELETE_file = "DELETE FROM files_upload WHERE id = ?";
    @Autowired
	public FileUploadInDb(DataSource dataSource) {
    	jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
 
    // This Method Is Used To Save The Uploaded File In The Database
    public static void fileSaveInDb(FileUpload fileUploadObj) {
 
       
 
        if(null != jdbcTemplateObj) {
 
            
            
            int insertCount = jdbcTemplateObj.update(sqlInsertQuery, fileUploadObj.getFileName(), fileUploadObj.getFileDescription(), fileUploadObj.getData());
            if(insertCount == 1) {
                System.out.println("The Uploaded File Is Successfully Saved In The Database...!" + "\n");
            } else {
                System.out.println("Error Occured While Saving The Uploaded File In The Database... Please Check...!" + "\n");
            }
        } else {
            System.out.print("Application Is Not Able To Bind With The Database! Please Check!");
        }
    }
    
    public boolean deleteFeedback(int idToDelete) {
		return jdbcTemplateObj.update(SQL_DELETE_file, idToDelete) > 0;
	}

}
