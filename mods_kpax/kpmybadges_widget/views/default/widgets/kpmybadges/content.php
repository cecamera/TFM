<?php 
/** 
* Widget display code
* This is the widget content view
*/ 

$thedisplaymode = $vars['entity']->display_mode;

// introductory text
$the_msg = elgg_echo('kpmybadges:message');
echo "<h3>$the_msg</h3>"; 

$loggedUser = elgg_get_logged_in_user_entity();
$page_owner = $loggedUser->username;
$objKpax = new kpaxSrv($page_owner);
$badgesList = $objKpax->getUserBadgesList($page_owner, $_SESSION["campusSession"]);

$iconPath = elgg_get_site_url() . "mod/kpmybadges_widget/graphics/kpaxicons/";

switch ($thedisplaymode) {

// display badges in a list with toggled entries
case 'List with toggled entries':
  echo '<div class = "elgg-output">'; 
  echo '<ul>'; 
  $badgenum = 1; 
  foreach ($badgesList as $badge) {
    $theName = $badge[0];
    $theDescription = $badge[1];
    $theImage = $badge[2];
    $theDate = $badge[3];
    echo '<li>';
    $body = '<dl class = "elgg-output">' . '<dt>' . $theName . '</dt><dd>' . $theDescription . '</dd></dl>';
    $body = $body . elgg_echo('badge:dateachiev') . $theDate;
    echo elgg_view('output/url', array(
      'href' => '#hrb'. $badgenum,
      'rel' => 'toggle',
      'text' => $theName,
    )); 
    echo ' ';
    echo '<img src="';
    $imagePath = $iconPath . $theImage;
    echo $imagePath;
    echo '" width = "24" height = "24">';
    echo elgg_view_module('info', elgg_echo('badge:details'), $body, array('id' => 'hrb' . $badgenum, 'class' => 'hidden')); 
    echo '</li>';
    $badgenum++;
  }
  echo '</ul>'; 
  echo '</div>';
  break;

// display badges in an list with tooltips
case 'List with tooltips':
  $tooltip_warning = elgg_echo('kpmybadges:tooltip_warning');
  echo "<h4>$tooltip_warning</h4>"; 	
  echo '<div class = "elgg-output">'; 
  echo '<ul>'; 
  foreach ($badgesList as $badge) {
    $theName = $badge[0];
    $theDescription = $badge[1];
    $theImage = $badge[2];
    $theDate = $badge[3];
    echo "<li><acronym title = '$theDescription'>$theName</acronym></li>";
  }
  echo '</ul>'; 
  echo '</div>';
  break;

// display badges in a descriptive list
case 'Descriptive list':
  echo '<dl class = "elgg-output">'; 
  foreach ($badgesList as $badge) {
    $theName = $badge[0];
    $theDescription = $badge[1];
    $theImage = $badge[2];
    $theDate = $badge[3];
    echo "<dt>$theName</dt><dd>$theDescription</dd>";
  }
  echo '</dl>';
  break;

}
