
let combinesTwoArrays = function(list1,list2)
{
  let totalLength = list1.length+list2.length;
  let combinesArray = [];
  let list1_index=0,list2_index=0;
  for(let index=0; index<totalLength;index++) {
    if(index%2==0) {
        combinesArray[index]=list1[ list1_index++];
    } else {
        combinesArray[index]=list2[ list2_index++];
    }
  }
  console.log(combinesArray);
}
let list1 = [5,10,15];
let list2 = ['A', 'B', 'C'];
combinesTwoArrays(list1,list2);
