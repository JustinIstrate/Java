<!DOCTYPE html>
<html>
<head>
    <title>Repository Report</title>
</head>
<body>
<h1>Repository Report</h1>
<ul>
    <#list repository.listDocuments() as document>
        <li>${document}</li>
    </#list>
</ul>
</body>
</html>
