<?php 
/** 
* Widget edit code 
* User selects the display mode
* This is the widget editable part
*/ 

// set default value 
if (!isset($vars['entity']->display_mode)) { 
  $vars['entity']->display_mode = "List with toggled entries"; 
}

// when Elgg handles the saving, names need to be params[<var name>] 
$params = array( 
  'name' => 'params[display_mode]', 
  'value' => $vars['entity']->display_mode, 
  'options' => array('List with toggled entries', 'Descriptive list', 'List with tooltips'), 
); 

// create a dropdown list with the $params array
$dropdown = elgg_view('input/dropdown', $params); 
?> 

<div> 
  <?php echo elgg_echo('kpmybadges:choice_display_mode'); ?>: 
  <?php echo $dropdown; ?> 
</div>
 
