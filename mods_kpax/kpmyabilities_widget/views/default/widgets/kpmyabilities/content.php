<?php 
/** 
* Widget display code
* This is the widget content view
*/ 

$maxAbilities = $vars['entity']->numberAbilities; 

// introductory text
$the_msg = elgg_echo('kpmyabilities:message');
echo "<h3>$the_msg</h3>"; 

$loggedUser = elgg_get_logged_in_user_entity();
$page_owner = $loggedUser->username;
$objKpax = new kpaxSrv($page_owner);
$abilitiesList = $objKpax->getUserAbilitiesList($page_owner, $_SESSION["campusSession"]);
global $CONFIG;

$iconPath = elgg_get_site_url() . "mod/kpmyabilities_widget/graphics/kpaxicons/";

echo '<dl class = "elgg-output">';
  $nItems = 1;
  echo '<ul><h4>';
  foreach ($abilitiesList as $oneAbility) {
    $abilityName = $oneAbility[1];
    $abilityId = strval($oneAbility[0]);
    $abilityLevel = strval($oneAbility[2]);
    echo "<li>";
    echo $abilityName;
    echo " (";
    echo $abilityLevel;
    echo ")</li>";
    $proficienciesList = $objKpax->getUserProficienciesList($page_owner, $abilityId, $_SESSION["campusSession"]);
    echo '<ul>'; 
    foreach ($proficienciesList as $oneProficiency) {
        echo '<li>';
        echo $oneProficiency[0];
        echo ', level ';
        echo $oneProficiency[1];
        echo ',  ';
        echo '<img src="';
	$theImage = $iconPath . $oneProficiency[2];
        echo $theImage;
	echo '" width = "24" height = "24">';
        echo '</li>';
    }
    echo '</ul>';
    if ($nItems == $maxAbilities) { 
      break;
    } 
    $nItems++;
  }
echo '</h4></ul>';
echo '</dl>';

