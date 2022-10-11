package com.jxxx.tiyu_pad.api;


import com.jxxx.tiyu_pad.base.Result;
import com.jxxx.tiyu_pad.bean.AuthLoginBean;
import com.jxxx.tiyu_pad.bean.CourseTypeListAllBean;
import com.jxxx.tiyu_pad.bean.DictDataTypeBean;
import com.jxxx.tiyu_pad.bean.PostStudentBean;
import com.jxxx.tiyu_pad.bean.PostStudentResults;
import com.jxxx.tiyu_pad.bean.SchoolClassBean;
import com.jxxx.tiyu_pad.bean.SchoolClassRecordBean;
import com.jxxx.tiyu_pad.bean.SchoolCourseBean;
import com.jxxx.tiyu_pad.bean.SchoolCourseBeanSmall;
import com.jxxx.tiyu_pad.bean.SchoolStudentBean;
import com.jxxx.tiyu_pad.bean.SchoolStudentDetailBean;
import com.jxxx.tiyu_pad.bean.UserInfoProfileBean;
import com.jxxx.tiyu_pad.bean.VersionResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /**
     * 登录方法
     * @return
     */
    @POST("auth/login")
    Observable<Result<AuthLoginBean>> postAuthLogin(@Body RequestBody body);

    /**
     * 登录方法
     * @return
     */
    @PUT("school/classRecord")
    Observable<Result> postResultsBatchAdd(@Body PostStudentBean mPostStudentBean);

    /**
     * 登录方法
     * @return
     */
    @POST("auth/register")
    Observable<Result> postAuthRegister(@Body RequestBody body);
    /**
     * 新增上课记录
     * @return
     */
    @POST("school/classRecord")
    Observable<Result> postSchoolClassRecord(@Body PostStudentResults mPostStudentResult);

    /**
     * 登出方法
     * @return
     */
    @DELETE("auth/logout")
    Observable<Result> deleteAuthLogout();

    /**
     * 根据当前时间查询课程
     * @return
     */
    @GET("school/course/queryCourse")
    Observable<Result<SchoolCourseBean>> getSchoolCourseQueryCourse();

    /**
     * 查询大课程列表
     * @return
     */
    @GET("school/course/list")
    Observable<Result<List<SchoolCourseBean>>> getSchoolCourseList(@Query("courseName") String courseName,
                                                                   @Query("ageRange") String ageRange,
                                                                   @Query("contentType") String contentType,
                                                                   @Query("category") String category,
                                                                   @Query("theme") String theme,
                                                                   @Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 查询班级列表
     * @return
     */
    @GET("school/class/list")
    Observable<Result<List<SchoolClassBean>>> getSchoolClassList(@Query("teacherId") String teacherId, @Query("schoolId") String schoolId, @Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

    /**
     * 查询学生列表
     * @return
     */
    @GET("school/student/list")
    Observable<Result<List<SchoolStudentBean>>> getSchoolStudentList(@Query("classId") String classId,
                                                                     @Query("gender") String gender,
                                                                     @Query("searchValue") String searchValue,
                                                                     @Query("pageNum") Integer pageNum,
                                                                     @Query("pageSize") Integer pageSize);

    /**
     * 获取学生详细信息
     * @return
     */
    @GET("school/student/{id}")
    Observable<Result<SchoolStudentDetailBean>> getSchoolStudentDetail(@Path("id") String id);

    /**
     * 修改学生
     * @return
     */
    @PUT("school/student")
    Observable<Result> getSchoolStudentPut(@Body SchoolStudentDetailBean mSchoolStudentDetailBean);

    /**
     * 新增学生
     * @return
     */
    @POST("school/student")
    Observable<Result> getSchoolStudentAdd(@Body SchoolStudentDetailBean mSchoolStudentDetailBean);

    /**
     * 获取学生详细信息
     * @return
     */
    @DELETE("school/student/{ids}")
    Observable<Result> getSchoolStudentDelete(@Path("ids") String ids);

    /**
     * 查询大课程详情
     * @return
     */
    @GET("school/course/{id}")
    Observable<Result<SchoolCourseBean>> getSchoolCourseDetail(@Path("id") String id);

    /**
     * 查询上课记录列表
     * @return
     */
    @GET("school/classRecord/list")
    Observable<Result<List<SchoolClassRecordBean>>> getSchoolClassRecordList(@Query("teacherId") String teacherId, @Query("classId") String classId);

    /**
     * 获取上课记录详细信息
     * @return
     */
    @GET("school/classRecord/{id}")
    Observable<Result<SchoolClassRecordBean>> getSchoolClassRecord(@Path("id") String id);

    /**
     * 查询小课程详情
     * @return
     */
    @GET("school/smallCourse/{id}")
    Observable<Result<SchoolCourseBeanSmall>> getSchoolSmallCourseDetail(@Path("id") String id);


    /**
     * 查询小课程列表
     * @return
     */
    @GET("school/smallCourse/list")
    Observable<Result<List<SchoolCourseBeanSmall>>> getSchoolCourseListSmall(@Query("courseName") String courseName,
                                                                             @Query("ageRange") String ageRange,
                                                                             @Query("contentType") String contentType,
                                                                             @Query("processType") String processType,
                                                                             @Query("trainType") String trainType,
                                                                             @Query("pageNum") int pageNum,@Query("pageSize") int pageSize);

    /**
     * 当前登陆教师
     */
    @GET("school/teacher/current")
    Observable<Result<UserInfoProfileBean>> getSchoolTeacherCurrent();


    /**
     * 用户设备
     */
    @GET("api/v1/version/getLast")
    Observable<Result<VersionResponse>> getLast(@Query("clientType") String clientType);


    /**
     * 分类条件
     */
    @GET("system/dict/data/type/{dictType}")
    Observable<Result<List<DictDataTypeBean>>> getDictDataType(@Path("dictType") String dictType);

    /**
     * 大类别：
     */
    @GET("school/courseType/listAll")
    Observable<Result<List<CourseTypeListAllBean>>> getCourseTypeListAll();

    /**
     * 上传文件
     *
     * @return
     */
    @Multipart
    @POST("api/v1/files")
    Observable<Result> submitFiles(@Part MultipartBody.Part[] file, @PartMap Map<String, RequestBody> map);

}
