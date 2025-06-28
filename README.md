# JavaDSA
Java DSA

Jan -02 

First issue thought to keep one instead of 2 branches so tried to
merge master with the main branch,
but issues first step i did

main -> git checkout main
main -> git merge master

error unable to merge to non common branches content


// to delete locally
git branch -d master

git merge master --allow-unrelated-histories

main -> git status

3 files are causing the conflict which is also present in main so removed those files from master
and then excetuded

git merge master

git add .


// to delete from remote repo git hub
git push origin --delete master

git commit -m "message"

git push origin main


// So then started working on the file now but got lot of 
conflicts and unable to run it so wasted 4hours ,
tired lot of steps sdk issues project setup,
blue color is file then it is set as src as root directory
otherwise we need to set it to root- src folder then it will be 
shown in blue color otherwise it is not at all firstly set to root source to run

Go to File > Project Structure (or press Ctrl + Alt + Shift + S).

Open File > Project Structure (Ctrl + Alt + Shift + S on Windows/Linux or ⌘ + ; on Mac).
Go to the Modules section on the left.
Click the + (Add) button at the top.
Select Import Module.
Navigate to your project folder, and select it.
IntelliJ will guide you through a wizard:
Choose Create module from existing sources.
Ensure the src folder is selected during the wizard when marking it as a source directory.
Click Finish to complete. I am done with this steps and blue color came on the folder now  I need to do this Go to the SDKs section under Project Structure (if not already set).
Click the + (Add) button and select JDK.
Navigate to your JDK installation folder (e.g., C:\Program Files\Java\jdk-20).
Select it and click OK.
Assign this JDK to your module under the Modules tab.


Now blue symbol came


git log --oneline
a6f69c4 (HEAD -> main, origin/main) Resolve merge conflicts in .idea config files
9096558 (origin/master, master) Added arrays
e8c20d8 Merge remote-tracking branch 'origin/main'
90a54e9 Merge branch 'main' of https://github.com/Nagarjuna325/JavaDSA
d0e0169 Merge branch 'main' of https://github.com/Nagarjuna325/JavaDSA
f99ed9c first commit
cf72aa4 Initial commit
PS C:\Users\nagar\Downloads\JavaDSA-main> git reset --hard 9096558
HEAD is now at 9096558 Added arrays
PS C:\Users\nagar\Downloads\JavaDSA-main> git push origin main --force
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/Nagarjuna325/JavaDSA
+ a6f69c4...9096558 main -> main (forced update)
  PS C:\Users\nagar\Downloads\JavaDSA-main> git log --oneline
  9096558 (HEAD -> main, origin/master, origin/main, master) Added arrays
  PS C:\Users\nagar\Downloads\JavaDSA-main>


git log --oneline to get commit history

git reset --hard 9096558

git push origin main --force

