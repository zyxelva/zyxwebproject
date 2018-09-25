package cn.taeyeon.zyx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author zyx
 * @date 2018/9/25 025 10:34
 */
@Api(tags = "老师信息-zyx")
@RestController
@RequestMapping(value = "/teacher")
@Validated
public class TestController {
    @ApiOperation(value = "查询老师已排未上的课节数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tuid", value = "老师uid", paramType = "query", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "courseId", value = "课程Id", paramType = "query", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "currentTime", value = "当前时间", paramType = "query", required = true, dataType = "Long")})
    @GetMapping(value = "/getLessonCount")
    public ResponseEntity<Integer> getLessonCount(
            @RequestParam("tuid") @Min(value = 1, message = "uid is empty") Long tuid,
            @RequestParam("courseId") @Min(value = 1, message = "courseIdEmpty") Long courseId,
            @RequestParam("currentTime") @Min(value = 0, message = "CurrentTimeEmpty") Long currentTime) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "根据课程ID查询课程老师", notes = "")
    @ApiImplicitParam(name = "courseId", value = "课程ID", paramType = "query", required = true, dataType = "Long")
    @GetMapping("/listByCourseId")
    public ResponseEntity<List<String>> listByCourseId(
            @RequestParam(name = "courseId") @Min(value = 1, message = "courseIdEmpty") Long courseId) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "根据老师tuid查询该老师的所有课程")
    @ApiImplicitParam(name = "tuid", value = "老师uid", paramType = "path", required = true, dataType = "Long")
    @GetMapping(value = "/listCourseByTuid/{tuid}")
    public ResponseEntity<List<String>> listCourseByTuid(
            @PathVariable("tuid") @Min(value = 1, message = "teacherUidEmpty") Long tuid) {
        return ResponseEntity.ok(null);
    }

}
