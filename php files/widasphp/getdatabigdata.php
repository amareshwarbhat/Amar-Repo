<?php
 
/*
 * Following code will list all the bigdatatable
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all bigdatatable from bigdatatable table
$result = mysql_query("SELECT *FROM bigdatatable") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // bigdatatable node
    $response["bigdatatable"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["icon"] = $row["icon"];
        $product["title"] = $row["title"];
        $product["description"] = $row["description"];
        
 
        // push single product into final response array
        array_push($response["bigdatatable"], $product);
    }
    // success
    $response["success"] = "1";
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no bigdatatable found
    $response["success"] = "0";
    $response["message"] = "No bigdatatable found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>
