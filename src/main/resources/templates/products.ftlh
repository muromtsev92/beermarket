<!DOCTYPE html>
<head>
    <title>BeerMarket</title>
</head>
<body>
<H1>Welcome to BeerMarket!</H1><hr>
<H4>All kinds of beer!</H4><hr>
<form action="/" method="get">
    Search lot by name: <input type="text" name="title"><br>
    <input type="submit" value="search">
</form>
<#list products as product>
    <div>
        <p>${product.title}</b> ${product.price} RUR | <a href="/product/${product.id}">More...</a></p>
    </div>
    <#else>
    <h3> No lots by now </h3>
</#list>
<hr>
<h3>New product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="title"><br><br>
    Description: <input type="text" name="description"><br><br>
    Price: <input type="number" name="price"><br><br>
    City: <input type="text" name="city"><br><br>
    Author: <input type="text" name="author"><br><br>
    First photo: <input type="file" name="file1"><br><br>
    Second photo: <input type="file" name="file2"><br><br>
    Third photo: <input type="file" name="file3"><br><br>
    <input type="submit" value="Add new beer"/><br><br>
</form>

</body>
</html>