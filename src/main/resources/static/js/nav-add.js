var a=angular.module("navadd",[]);

a.controller("navadd_controller",function ($scope,$http) {
        //数组
        $scope.studentName="";
        $scope.studentAge="";
        $scope.studentSex="";
        $scope.studentAdress="";
      //导航栏遍历方法
      $scope.navadd=function () {


          if ( $scope.studentName==""||$scope.studentName==null) {
              $scope.successmsg="";
              $scope.errormsg="导航名为空";
          }else if($scope.studentAge==""||$scope.studentAge==null){
              $scope.successmsg="";
              $scope.errormsg="年龄为空";
          }else if($scope.studentSex==""||$scope.studentSex==null){
              $scope.successmsg="";
              $scope.errormsg="性别为空";
          }else if($scope.studentAdress==""||$scope.studentAdress==null){
              $scope.successmsg="";
              $scope.errormsg="地址为空";
          }else{
              $scope.errormsg="";
              $http({
                  method: "put",
                  params:{studentName: $scope.studentName,age:$scope.studentAge,sex:$scope.studentSex,adress: $scope.studentAdress},
                  url:"/studentadd.do"
              }).success(function(result){
                  if (result.code==1){
                      layer.alert("<span style='color: red'>恭喜你添加成功</span>");
                      $scope.successmsg="恭喜你添加成功";

                  }
              });



          }


    }








});







