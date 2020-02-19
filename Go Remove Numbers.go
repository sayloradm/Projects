package main

import "strconv"
import "strings"
import "fmt"
import "io/ioutil"
import "os"
import "bufio"

func main(){
	//Get the opened file
	file := openRead()

	//Get the file back without numbers
	noNums := parseData(file)

	//Write the file to a new text file
	writeData(noNums)
}

func openRead()string {

	//Takes the input file as the second cmd line
	file, err := ioutil.ReadFile(os.Args[1])
	hndlErrs(err)

	//Converts the datafrom bytes to an array of strings
	str := string(file)

	return str
}

func parseData(readFile string) [73]string{

	//Split the array into single ints or letters
	parsedFile := strings.Split(readFile,"")
	var noNums [73]string
	var j int

	//loop through checking each word or int and add to new depending
	for i := 0; i < len(parsedFile); i++{

	// Don't need a first variable, sole purpose is to return error indicating str(error) or int(nil)
		_, err := strconv.Atoi(parsedFile[i])

		//If is not an int, add to a new string array
		if err != nil {

			noNums[j] = parsedFile[i]
			j = j +1
		}
	}
	return noNums

}

func writeData(parsedFile [73]string){

	//Create a reader to take user input for file name
	input := bufio.NewReader(os.Stdin)
	fmt.Print("What would you like the new file to be called? ")

	//Store file name in fileName
	fileName, err := input.ReadString('\n')
	hndlErrs(err)

	//Create the new file with user entered name
	file, err := os.Create(fileName + ".txt")
	hndlErrs(err)

	//Write the string array to the new file
	for i := 0; i < len(parsedFile); i++{

	fmt.Fprint(file,parsedFile[i])

	}

	//NEW FILE WILL BE MADE IN THE REMOTE FILE DIRECTORY OF BITVISE, etc.
}

func hndlErrs(e error){

	//Calls panic if the error is anything but nil
	if e != nil{
	panic(e)
	}
}
