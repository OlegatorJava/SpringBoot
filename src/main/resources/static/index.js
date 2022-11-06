angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.loadCart = function () {
        $http.get(contextPath + '/cart')
            .then(function (response) {
                $scope.cartList = response.data;
            });
    };


  $scope.delete = function (productId) {
      $http({
          url: contextPath + '/cart/delete',
          method: 'GET',
          params: {
              id: productId
          }
      }).then(function (response) {
          $scope.loadCart();
      });
  };

    $scope.add = function (productId) {
        $http({
            url: contextPath + '/cart/add',
            method: 'GET',
            params: {
                id: productId
            }
        }).then(function (response) {
            $scope.loadProducts();
            $scope.loadCart();
        });
    };

    $scope.loadProducts();
    $scope.loadCart();

});