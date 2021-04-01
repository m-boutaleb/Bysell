#!/bin/bash/

#############################################################################
# COMMENT TO ADD TO THE GIT COMMIT COMMAND
#############################################################################
COMMENT=""
BRANCH=`git rev-parse --abbrev-ref HEAD`
TAG=""
SHOW_TAGS=`git tag --list`
MASTER="master"
DEV="dev"
IS_TAG_CURRENT=1


#############################################################################
# COMMAND TO ADD TAG
#############################################################################
add_tag(){
	wait
	echo "All available tags:"
	echo $SHOW_TAGS
	wait
	git tag $TAG
}

#############################################################################
# COMMAND TO DO PUSH
#############################################################################
execute_push(){
	wait
	git push -u origin ${BRANCH}
}

#############################################################################
# COMMAND TO DO ADD AND COMMIT OF THE FILES
#############################################################################
execute_add_commit(){
	wait
	git add -A
	wait
	git commit -m "${COMMENT}" 
}

#############################################################################
# COMMAND TO DO PUSH WITH TAG
#############################################################################
execute_push_with_tag(){
	wait
	git push -u origin ${BRANCH} ${TAG}
}

#############################################################################
# FUNCTION TO CHANGE THE BRANCH AND DO THE MERGE
#############################################################################
execute_merge(){
	wait
	git checkout $1
	wait
	git merge ${BRANCH}
}

if [[ $# -eq 0 ]]; then
	echo -e "\e[33mWarning: you have not specified the commit message\e[0m"
	CURRENT_BRANCH=`git branch -a`
	echo -e "\e[32mCURRENT BRANCH: ${CURRENT_BRANCH}\e[0m"
	while [ -z "${COMMENT}" -a "$COMMENT" == "" ]; do
		read -p "Please enter the commit message:" comment
		COMMENT=\"${comment}\"
	done
else
	COMMENT=\"$1\"
fi

#############################################################################
# ASK FOR MERGE AND TAG IF NECESSARY
#############################################################################
read -p "Want to do a merge?[Y/n]" merge

read -p "Want to add a tag?[Y/n]" tag

if [ $tag == "Y" -o $tag == "y" ]; then 
		read -p "Enter the tag name:" new_tag
		TAG=$new_tag
fi

if [ $merge == "Y" -o $merge == "y" ]; then
	read -p "Insert the branch that you want to merge with the current:" branch_to_merge
	
	if [ $tag == "Y" -o $tag == "y" ]; then
		read -p "Tag commit of current or merge branch?[c=current branch/m=merge branch]" cm
		# FAKING TERNARY OPERATOR... REMEMBER 0 IS TRUE
		IS_TAG_CURRENT=$cm
	
		if [ $IS_TAG_CURRENT == "c" ]; then
			execute_add_commit
			add_tag
			execute_push_with_tag
			BRANCH=`git rev-parse --abbrev-ref HEAD`
			execute_merge $branch_to_merge
			execute_add_commit
			execute_push
			echo "certo che sono qua"
		else
			execute_add_commit
			execute_push
			BRANCH=`git rev-parse --abbrev-ref HEAD`
			execute_merge $branch_to_merge
			execute_add_commit
			add_tag
			execute_push_with_tag
		fi
	else
		execute_add_commit
		execute_push
		execute_merge $branch_to_merge
		execute add_commit
		execute_push
	 fi
else 
	execute_add_commit
	
	if [ $tag == "Y" -o $tag == "y" ]; then
		add_tag
		execute_push_with_tag
	else
		execute_push	
	fi
fi

#############################################################################
# ASK USER IF WANT TO CHECKOUT TO THE DEV BRANCH
#############################################################################
BRANCH=`git rev-parse --abbrev-ref HEAD`
if [ $BRANCH == $MASTER ]; then
	read -p "Want to checkout to dev?[Y/n]:" yn
	
	if [ $yn == "Y" -o $yn == "y" ]; then
		git checkout $DEV
	fi
fi


# FINISH
##############################################################################
echo -e "\e[32mGIT ADDED, COMMITTED AND PUSHED"


	
