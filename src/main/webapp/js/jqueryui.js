

$(function() {
	
/*    var tabTitle = $( "#tab_title" ),
      tabContent = $( "#tab_content" ),
      tabTemplate = "<li><a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close' role='presentation'>Remove Tab</span></li>",
      tabCounter = 2;*/
 
    var tabs = $( "#tabs" ).tabs();
    var btnClose = $("#btnClose");
    
    btnClose.click(function(){
    	$(".accordion").accordion({active:2})
    });
    
    
    // modal dialog init: custom buttons and a "close" callback resetting the form inside
    var dialog1 = $( ".dialog1" ).dialog({
      autoOpen: false,
      modal: true,
  
      close: function() {
        form[ 0 ].reset();
      }
    });
    var dialog2 = $( ".dialog2" ).dialog({
    	autoOpen: false,
    	modal: true,
    	
    	close: function() {
    		form[ 0 ].reset();
    	}
    });
    var dialog3 = $( ".dialog3" ).dialog({
    	autoOpen: false,
    	modal: true,
    	
    	close: function() {
    		form[ 0 ].reset();
    	}
    });
    var dialog4 = $( ".dialog4" ).dialog({
    	autoOpen: false,
    	modal: true,
    	
    	close: function() {
    		form[ 0 ].reset();
    	}
    });
    var dialog5 = $( ".dialog5" ).dialog({
    	autoOpen: false,
    	modal: true,
    	
    	close: function() {
    		form[ 0 ].reset();
    	}
    });
 
    // addTab form: calls addTab function on submit and closes the dialog
    //다이얼로그에서 submit 여기서 구현안함
    /*var form = dialog.find( "form" ).submit(function( event ) {
      addTab();
      dialog.dialog( "close" );
      event.preventDefault();
    });*/
 
    //content 크기만큼 높이를 갖게한다
    $( ".accordion" ).accordion({
    	heightStyle: "content",
		collapsible: true
    	});
    
    // 탭추가기능 보류
/*    function addTab() {
      var label = tabTitle.val() || "Tab " + tabCounter,
        id = "tabs-" + tabCounter,
        li = $( tabTemplate.replace( /#\{href\}/g, "#" + id ).replace( /#\{label\}/g, label ) ),
        tabContentHtml = tabContent.val() || "Tab " + tabCounter + " content.";
 
      tabs.find( ".ui-tabs-nav" ).append( li );
      tabs.append( "<div id='" + id + "'><p>" + tabContentHtml + "</p></div>" );
      tabs.tabs( "refresh" );
      tabCounter++;
    }*/
 
    // addTab button: 다이얼로그열기 
    $( "#add_tab1" )
      .button()
      .click(function() {
        dialog1.dialog( "open" );
      });
    $( "#add_tab2" )
    .button()
    .click(function() {
    	dialog2.dialog( "open" );
    });
    $( "#add_tab3" )
    .button()
    .click(function() {
    	dialog3.dialog( "open" );
    });
    $( "#add_tab4" )
    .button()
    .click(function() {
    	dialog4.dialog( "open" );
    });
    $( "#add_tab5" )
    .button()
    .click(function() {
    	dialog5.dialog( "open" );
    });

 
    // close icon: removing the tab on click
    // 탭지우기 보류
    /*tabs.delegate( "span.ui-icon-close", "click", function() {
      var panelId = $( this ).closest( "li" ).remove().attr( "aria-controls" );
      $( "#" + panelId ).remove();
      tabs.tabs( "refresh" );
    });*/
 
    tabs.bind( "keyup", function( event ) {
      if ( event.altKey && event.keyCode === $.ui.keyCode.BACKSPACE ) {
        var panelId = tabs.find( ".ui-tabs-active" ).remove().attr( "aria-controls" );
        $( "#" + panelId ).remove();
        tabs.tabs( "refresh" );
      }
    });
  });
