<?php

//
// Modified by jcbrocca - ccamera
//

 $username = elgg_get_logged_in_user_entity()->username;


$title = elgg_echo($username . " Games");

elgg_register_title_button();

//DEFAULT OPTIONS FOR ELGG LISTING.
$options = array(
    'types' => 'object',
    'subtypes' => 'kpax',
    'limit' => 10,
    'full_view' => false
        );


//GETTING THE GAME LIST FROM SRVKPAX
$objKpax = new kpaxSrv(elgg_get_logged_in_user_entity()->username);

$objKpax = new kpaxSrv($username); //Get games list from kpaxSrv

$gameList = $objKpax->getDeveloperGames($_SESSION["campusSession"], $username);

if(isset($gameList))
{
	system_message(elgg_echo('kpax:list:success'));

	$_SESSION['gameListFields'] = $fields;
	$_SESSION['gameListValues'] = $values;
}

	if (empty($gameList))

		$content = '<p>' . elgg_echo('kpax:none') . '</p>';
	else
	{		
		/*
		 * Adding the gameIds to the elgg list.
		 * 
		 * Forcing elgg to list the games in the same
		 	* order as gotten from srvKpax. Not by default
		 * elgg order (time_created desc).
		 */

		$where = array();
		$orderBy = ' CASE ';
		for($i = 0, $size = sizeof($gameList); $i < $size; ++$i)
		{
			$idGame = $gameList[$i]->idGame;
		
			$where[] = $idGame;
			$orderBy = $orderBy . " WHEN e.guid = " . $idGame . " THEN " . ($i + 1);

		}
		$options = array_merge($options, array('guids' => $where));

		$orderBy = $orderBy . " END ";
		$options = array_merge($options, array('order_by' => $orderBy));
		$content = elgg_list_entities($options);		
	}
	$options = array_merge($options, array('guids' => $where));
	$orderBy = $orderBy . " END ";
	$options = array_merge($options, array('order_by' => $orderBy));
}
else
    register_error(elgg_echo('kpax:list:failed:my_dev'));

//LISTING THE GAMES.

if (!$content) {
    $content = '<p>' . elgg_echo('kpax:none') . '</p>';
}

$body = elgg_view_layout('content', array(
    'filter' => false,
    'content' => $content,
    'title' => $title,
    'sidebar' => elgg_view('kpax/sidebar'),
        ));
echo elgg_view('input/hidden', array('name' => 'container_guid', 'value' => $container_guid));

echo elgg_view_page($title, $body);

?>
