<!DOCTYPE html>
<head>
    <title>BeerMarket</title>
</head>
<body>
<H1>Welcome to the BeerMarket!</H1><hr>
<H4>Product info</H4>
<b>Name: </b>${product.title}<br>
<b>Descr: </b>${product.description}<br>
<b>Price: </b>${product.price}<br>
<b>City: </b>${product.city}<br>
<hr>
<h3>Delete product</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete this product"/>
</form>

</body>
</html>