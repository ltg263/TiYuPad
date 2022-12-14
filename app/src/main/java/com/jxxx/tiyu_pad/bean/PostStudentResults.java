package com.jxxx.tiyu_pad.bean;

public class PostStudentResults {

    @Override
    public String toString() {
        return "PostStudentResults{" +
                "courseId='" + courseId + '\'' +
                ", smallCourseId='" + smallCourseId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", timeUse='" + timeUse + '\'' +
                ", times='" + times + '\'' +
                ", finishTimes='" + finishTimes + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }

    public PostStudentResults() {

    }

    public PostStudentResults(String classDate, String classId, String classSceduleCardId, String teacherId, String courseId, String smallCourseId) {
        this.classDate = classDate;
        this.classId = classId;
        this.classSceduleCardId = classSceduleCardId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.smallCourseId = smallCourseId;
    }

    public String classDate;
    public String classId;
    public String classSceduleCardId;
    public String teacherId;

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassSceduleCardId(String classSceduleCardId) {
        this.classSceduleCardId = classSceduleCardId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassDate() {
        return classDate;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassSceduleCardId() {
        return classSceduleCardId;
    }

    public String getTeacherId() {
        return teacherId;
    }


    /**
     * courseId : 0
     * createBy :
     * createTime :
     * delTf : 0
     * id : 0
     * params : {}
     * searchValue :
     * smallCourseId : 0
     * speed : 0
     * status : 0
     * studentId : 0
     * timeUse : 0
     * times : 0
     * updateBy :
     * updateTime :
     */

    private String courseId;//	?????????id
    private String smallCourseId;//	?????????id
    private String studentId;//??????id
    private String timeUse;//??????
    private String times;//	????????????
    private String finishTimes;//????????????
    private String speed;//	????????????

    public void setFinishTimes(String finishTimes) {
        this.finishTimes = finishTimes;
    }

    public String getFinishTimes() {
        return finishTimes;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }



    public String getSmallCourseId() {
        return smallCourseId;
    }

    public void setSmallCourseId(String smallCourseId) {
        this.smallCourseId = smallCourseId;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
    public static class ParamsBean {
    }
}
