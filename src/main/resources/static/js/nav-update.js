var a=angular.module("navupdate",[]);

a.controller("navupdate_controller",function ($scope,$http) {
        //数组
    $scope.studentName="";
    $scope.studentAge="";
    $scope.studentSex="";
    $scope.studentAdress="";

     $scope.errormsg="";
     $scope.successmsg="";
      //导航栏遍历方法
        $scope.showupdatenav=function(){
            $scope.studentName=window.localStorage.getItem("student_edit_Name");
            $scope.studentAge=window.localStorage.getItem("student_edit_age");
            $scope.studentSex=window.localStorage.getItem("student_edit_sex");
            $scope.studentAdress=window.localStorage.getItem("student_edit_adress");
        }

       $scope.navupdate=function () {
           layer.confirm('<span style=\'color: red\'>确认修改吗？</span>',function(){
               if ( $scope.studentName=="") {
                   $scope.successmsg="";
                   $scope.errormsg="姓名为空";
               }else if($scope.studentAge==""){
                   $scope.successmsg="";
                   $scope.errormsg="年龄为空";
               }else if($scope.studentSex==""){
                   $scope.successmsg="";
                   $scope.errormsg="性别为空";
               }else if($scope.studentAdress=="") {
                   $scope.successmsg = "";
                   $scope.errormsg = "地址为空";
               } else{
                   var id=window.localStorage.getItem("student_edit_id");

                   $scope.errormsg="";

                   $http({
                       method: "post",
                       params:{studentName: $scope.studentName,age:$scope.studentAge,sex: $scope.studentSex,address: $scope.studentAdress,id:id},
                       url:"/studentupdate.do"
                   }).success(function(result){
                       if (result.code==1){
                           layer.alert("<span style='color: red'>恭喜你修改成功</span>");
                           $scope.successmsg="";
                           $scope.successmsg="恭喜你修改成功";
                       }
                   });



               }
           });



    }  //方法1



    $scope.showupdatenav();








});







