package java;
import com.raymon.api.poi.ExcelUtil;
import com.raymon.api.poi.callback.Callback;
import com.raymon.api.poi.thread.BaseThreadPool;
import com.raymon.api.poi.thread.SimpleThreadPool;
import com.raymon.api.pojo.user.UserPojo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

public class testThreadPool{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testThreadPool() throws InterruptedException {

        ArrayBlockingQueue<Map<String,String>> queue = new ArrayBlockingQueue<>(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExcelUtil.readFirst("C:\\Users\\Administrator\\Desktop\\新建XLSX 工作表.xlsx", new Callback() {
                    @Override
                    public void callback(Map<String, String> map, int currentRowNumber, int availabledRows) {
                        try {
                            queue.put(map);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
        SimpleThreadPool pool = new SimpleThreadPool(5);
        boolean flag = true;
        int m = 0;
        while (flag){
            Map<String, String> map = queue.poll();
            if (map==null||map.isEmpty()){
                m++;
                if (m>100) flag=false;
                else
                    Thread.currentThread().sleep(10);
            }else {
                m = 0;
                UserPojo a = ExcelUtil.resultToObj(map, UserPojo.class);
                pool.execute(new BaseThreadPool.Execute() {
                    @Override
                    public void execute() {
                        jdbcTemplate.update("insert into u_user(id,pswd,email,nikename,status,create_name,last_login_time) values (?,?,?,?,?,?,?)",
                                a.getId(),a.getPswd(),a.getEmail(),a.getNickname(),a.getStatus(),a.getCreateTime(),a.getLastLoginTime());
                    }
                });
            }
        }
    }
}
