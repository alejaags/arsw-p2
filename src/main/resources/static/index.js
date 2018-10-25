// Builds the HTML Table out of myList.


function buildHtmlTable() {
    var b = document.getElementById("bu");
    var t = document.getElementById("time");
console.log(t)
    axios.get('/stock/'+t.value+'/'+b.value)
            .then(function(result){
                    var myList = result.data;
                    var selector = document.getElementById("excelDataTable");
                    console.log(myList);
                    for(var prop in myList) {
                        if(prop.indexOf('Time') > -1){
                            console.log(prop,myList[prop]); 
                            mmy = myList[prop]
                            for(var prop2 in mmy) {
                                var columns = addAllColumnHeaders(mmy[prop2], selector);
                                break;
                            }
                            for(var prop2 in mmy) {
                                var row$ = $('<tr/>');
                                 row$.append($('<td/>').html(prop2));
                                for(var prop3 in mmy[prop2]) {
                                   var cellValue = mmy[prop2][prop3];
                                   if (cellValue == null) cellValue = "";
                                   row$.append($('<td/>').html(cellValue));
                                }
                            $(selector).append(row$);
                            }
                            
                            
                        }
                         
                    }
                    
            })
            .catch(function(error){
                    console.log(error);
                    errorMessage();
            });
  

  
}

// Adds a header row to the table and returns the set of columns.
// Need to do union of keys from all records as some records may not contain
// all records.
function addAllColumnHeaders(myList, selector) {
  var columnSet = [];
  var headerTr$ = $('<tr/>');
headerTr$.append($('<th/>').html("date"));
  console.log(myList);
  for(var i in myList) {
    console.log("puta vida");
    console.log(i)
    if ($.inArray(i, columnSet) == -1) {
        columnSet.push(i);
        headerTr$.append($('<th/>').html(i));
    }
  }
  $(selector).append(headerTr$);

  return columnSet;
}

