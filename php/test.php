<?php 
/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
session_start();
define("JSONDEDET",1);

include_once "jsondedet.php";
include_once "mydata.php";

//echo "hello world<br>";
$myJson = new JSONDEDET;
$myData = new MyData;

?>
<form>
<table>
<tr>
	<td>Category</td>
	<td><select name="category" id="category" >
<?php
		foreach (array_keys($myData->myData) as $key) {
			echo "<option value=\"$key\">$key</option>";
		}
?>
		</select>
	</td>
</tr>
<tr>
	<td colspan=2> <input type="submit"/></td>
</tr>
</table>
</form>
<?php 

$isRequest = !empty($_REQUEST);
/*
//Ok
echo "<pre>";
//var_dump($_REQUEST); 
print_r($_REQUEST); 
echo "</pre>";
echo "<br>";
*/

if ($isRequest) {
	$found = false;
	foreach (array_keys($_REQUEST) as $req) {
		if (strcasecmp($req,"category")==0) {
			echo $req." ".$_REQUEST[$req]."<br>";
			foreach (array_keys($myData->myData) as $key) {
				if (strcasecmp($_REQUEST[$req],$key)==0) {
					//echo "found";
					$found = true;
					//print_r($myData->myData[$key]);
					$myJson->setData($myData->myData[$key]);
				} 
			}
		}
	}

	if (!$found) {
		$myJson->setResponse(404);
	}
}
echo $myJson->toJSON();

?> 
